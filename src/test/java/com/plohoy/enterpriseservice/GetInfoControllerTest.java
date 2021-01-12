package com.plohoy.enterpriseservice;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.plohoy.enterpriseservice.annotation.MvcIntegrationTest;
import com.plohoy.enterpriseservice.util.InnHelper;
import com.plohoy.enterpriseservice.util.TestCaseBuilder;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@MvcIntegrationTest
@RunWith(Parameterized.class)
public class GetInfoControllerTest {
    @ClassRule public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
    @Rule public final SpringMethodRule springMethodRule = new SpringMethodRule();
    @Autowired private MockMvc mvc;
    @Autowired private InnHelper innHelper;
    private String externalRandomInn;

    private String infoTypeName;
    private String testInnFromSql;
    private int testResponseFromSqlLength;

    public GetInfoControllerTest(
            String infoTypeName,
            String testInnFromSql,
            int testResponseFromSqlLength
    ) {
        this.infoTypeName = infoTypeName;
        this.testInnFromSql = testInnFromSql;
        this.testResponseFromSqlLength = testResponseFromSqlLength;
    }

    @Parameterized.Parameters(name = "{0} test")
    public static Collection<Object[]> data() {
        return Arrays.asList(TestCaseBuilder.getSqlTestCases());
    }

    @Before
    public void initInn() {
        do {
            externalRandomInn = innHelper.getRandomInn();
        } while (externalRandomInn == testInnFromSql);
    }

    @Test
    @Sql(value = "/sql/create-info-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "/sql/drop-info-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void shouldGetInfoFromDB() throws Exception {
        MvcResult mvcResult = mvc.perform(
                get(String.format("/%s/%s", infoTypeName, testInnFromSql)))
                .andDo(print())
                .andExpect(handler().methodName("getFnsInfo"))
                .andExpect(status().isOk())
                .andExpect(header().exists("Content-Type"))
                .andExpect(header().string("Content-Type", "application/json"))
                .andExpect(content().encoding("ISO-8859-1"))
                .andExpect(content().string(Matchers.hasLength(testResponseFromSqlLength)))
                .andReturn();

        String errorMessage = mvcResult.getResponse().getErrorMessage();
        assertNull(errorMessage);
    }

    @Test
    public void failedByLargeInn() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, innHelper.getLargeInn())))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                innHelper.getInnSizeErrorMessage(),
                                innHelper.getMinInnSizeProperty(),
                                innHelper.getMaxInnSizeProperty()))));
    }

    @Test
    public void failedBySmallInn() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, innHelper.getSmallInn())))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                innHelper.getInnSizeErrorMessage(),
                                innHelper.getMinInnSizeProperty(),
                                innHelper.getMaxInnSizeProperty()))));
    }

    @Test
    public void failedByNormalInvalidInn() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, innHelper.getSmallInn() + "-")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(
                        Matchers.containsString(innHelper.getInnFormatErrorMessage())));
    }

    @Test
    public void failedByLargeInvalidInn() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, innHelper.getLargeInn() + "-")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                innHelper.getInnSizeErrorMessage(),
                                innHelper.getMinInnSizeProperty(),
                                innHelper.getMaxInnSizeProperty()))))
                .andExpect(content().string(
                        Matchers.containsString(innHelper.getInnFormatErrorMessage())));
    }

    @Test
    public void failedByNormalSpaceInn() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, innHelper.getSmallInn() + " ")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(
                        Matchers.containsString(innHelper.getInnFormatErrorMessage())));
    }

    @Test
    public void failedByLargeSpaceInn() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, innHelper.getLargeInn() + " ")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                innHelper.getInnSizeErrorMessage(),
                                innHelper.getMinInnSizeProperty(),
                                innHelper.getMaxInnSizeProperty()))))
                .andExpect(content().string(
                        Matchers.containsString(innHelper.getInnFormatErrorMessage())));
    }

    @Test
    public void failedByNormalLetterInn() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, innHelper.getSmallInn() + "q")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(
                        Matchers.containsString(innHelper.getInnFormatErrorMessage())));
    }

    @Test
    public void failedByLargeLetterInn() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, innHelper.getLargeInn() + "q")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                innHelper.getInnSizeErrorMessage(),
                                innHelper.getMinInnSizeProperty(),
                                innHelper.getMaxInnSizeProperty()))))
                .andExpect(content().string(
                        Matchers.containsString(innHelper.getInnFormatErrorMessage())));
    }

    @Test
    public void failedByBlankInn() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, " ")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                innHelper.getInnSizeErrorMessage(),
                                innHelper.getMinInnSizeProperty(),
                                innHelper.getMaxInnSizeProperty()))))
                .andExpect(content().string(
                        Matchers.containsString(innHelper.getInnFormatErrorMessage())))
                .andExpect(content().string(
                        Matchers.containsString(innHelper.getInnBlankErrorMessage())));
    }

    @Test
    public void failedByEmptyInn() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, "")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedByExternalInn() throws Exception {
        MvcResult mvcResult = mvc.perform(
                get(String.format("/%s/%s", infoTypeName, externalRandomInn)))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        String errorMessage = mvcResult.getResponse().getErrorMessage();
        assertEquals(innHelper.getInnNotFoundMessage(), errorMessage);
    }
}
