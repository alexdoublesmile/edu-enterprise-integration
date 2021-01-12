package com.plohoy.enterpriseservice;

import org.hamcrest.Matchers;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.method.HandlerMethod;
import com.plohoy.enterpriseservice.annotation.MvcIntegrationTest;
import com.plohoy.enterpriseservice.controller.AbstractSyncController;
import com.plohoy.enterpriseservice.controller.BaseSyncController;
import com.plohoy.enterpriseservice.entity.BaseJsonbEntity;
import com.plohoy.enterpriseservice.initstrategy.BaseStrategy;
import com.plohoy.enterpriseservice.request.SmevRequestType;
import com.plohoy.enterpriseservice.service.storeservice.AbstractStoreService;
import com.plohoy.enterpriseservice.service.storeservice.BaseStoreService;
import com.plohoy.enterpriseservice.util.InnHelper;
import com.plohoy.enterpriseservice.util.TestCaseBuilder;
import com.plohoy.enterpriseservice.util.StoreServiceFactory;
import com.plohoy.enterpriseadapter.dto.ResponseDto;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@MvcIntegrationTest
@RunWith(Parameterized.class)
public class SyncControllerTest {
    @ClassRule public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
    @Rule public final SpringMethodRule springMethodRule = new SpringMethodRule();
    @Autowired private MockMvc mvc;
    @Autowired private StoreServiceFactory serviceFactory;
    @Autowired private InnHelper innHelper;

    private Class<? extends BaseJsonbEntity> expectedInfoType;
    private Class<? extends BaseStrategy> expectedStrategyType;
    private Class<? extends BaseSyncController> expectedControllerType;
    private Class<? extends BaseStoreService> expectedStoreServiceType;
    private Class <?> expectedRequestDtoType;
    private Class<? extends ResponseDto> expectedResponseDtoType;
    private String infoTypeName;
    private String expectedRequestUrl;
    private String expectedFindClientByIdUrl;
    private SmevRequestType expectedSmevRequestType;

    public SyncControllerTest(
            Class<? extends BaseJsonbEntity> expectedInfoType,
            Class<? extends BaseStrategy> expectedStrategyType,
            Class<? extends BaseSyncController> expectedControllerType,
            Class<? extends BaseStoreService> expectedStoreServiceType,
            Class expectedRequestDtoType,
            Class<? extends ResponseDto> expectedResponseDtoType,
            String infoTypeName,
            String expectedRequestUrl,
            String expectedFindClientByIdUrl,
            SmevRequestType expectedSmevRequestType
            ) {
        this.expectedInfoType = expectedInfoType;
        this.expectedStrategyType = expectedStrategyType;
        this.expectedControllerType = expectedControllerType;
        this.expectedStoreServiceType = expectedStoreServiceType;
        this.expectedRequestDtoType = expectedRequestDtoType;
        this.expectedResponseDtoType = expectedResponseDtoType;
        this.infoTypeName = infoTypeName;
        this.expectedRequestUrl = expectedRequestUrl;
        this.expectedFindClientByIdUrl = expectedFindClientByIdUrl;
        this.expectedSmevRequestType = expectedSmevRequestType;
    }

    @Parameterized.Parameters(name = "sync {9} test")
    public static Collection<Object[]> data() {
        return Arrays.asList(TestCaseBuilder.getSyncTestCases());
    }

    @Test
    public void shouldSyncExpectedInfo() throws Exception {
        mvc.perform(
                    post(String.format("/%s/sync", infoTypeName))
                    .param("inn", innHelper.getRandomInn()))

                .andDo(print())
                .andExpect(handler().handlerType(expectedControllerType))
                .andExpect(handler().methodName("syncSmev"))
                .andExpect(status().isOk())
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(Matchers.any(String.class)))
                .andExpect(request().asyncResult(Matchers.hasLength(36)));
    }

    @Test
    public void shouldSetExpectedStrategy() throws Exception {
        MvcResult mvcResult = mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(innHelper.getRandomInn()))
                .andDo(print())
                .andReturn();

        BaseStrategy actualStrategy = ((AbstractSyncController) ((HandlerMethod) mvcResult
                .getHandler())
                .getBean())
                .getStrategy();

        assertEquals(expectedStrategyType, actualStrategy.getClass());
        assertEquals(expectedRequestUrl, actualStrategy.getRequestPath());
        assertEquals(expectedFindClientByIdUrl, actualStrategy.getFindIdPathTemplate());
        assertEquals(expectedSmevRequestType, actualStrategy.getRequestType());
        assertEquals(expectedRequestDtoType, actualStrategy.getRequestDto(innHelper.getRandomInn()).getClass());
        assertEquals(expectedResponseDtoType, actualStrategy.getResponseDtoClass());
    }

    @Test
    public void shouldSetExpectedStoreService() throws Exception {
        MvcResult mvcResult = mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(innHelper.getRandomInn()))
                .andDo(print())
                .andReturn();

        BaseStrategy actualStrategy = ((AbstractSyncController) ((HandlerMethod) mvcResult
                .getHandler())
                .getBean())
                .getStrategy();
        BaseStoreService actualStoreService = serviceFactory.getStoreService(
                actualStrategy.getRequestType());

        assertEquals(expectedStoreServiceType, actualStoreService.getClass());
    }

    @Test
    public void failedByLargeInn() throws Exception {
        mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(innHelper.getLargeInn()))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(request().asyncNotStarted())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedBySmallInn() throws Exception {
        mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(innHelper.getSmallInn()))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(request().asyncNotStarted())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedByNormalInvalidInn() throws Exception {
        mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(innHelper.getSmallInn() + "-"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(request().asyncNotStarted())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedByLargeInvalidInn() throws Exception {
        mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(innHelper.getLargeInn() + "-"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(request().asyncNotStarted())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedByNormalSpaceInn() throws Exception {
        mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(innHelper.getSmallInn() + " "))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(request().asyncNotStarted())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedByLargeSpaceInn() throws Exception {
        mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(innHelper.getLargeInn() + " "))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(request().asyncNotStarted())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedByNormalLetterInn() throws Exception {
        mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(innHelper.getSmallInn() + "q"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(request().asyncNotStarted())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedByLargeLetterInn() throws Exception {
        mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(innHelper.getLargeInn() + "q"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(request().asyncNotStarted())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedByBlankInn() throws Exception {
        mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(" "))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(request().asyncNotStarted())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedByEmptyInn() throws Exception {
        mvc.perform(
                post(String.format("/%s/sync", infoTypeName))
                        .content(""))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(request().asyncNotStarted())
                .andExpect(content().string(Matchers.emptyString()));
    }
}