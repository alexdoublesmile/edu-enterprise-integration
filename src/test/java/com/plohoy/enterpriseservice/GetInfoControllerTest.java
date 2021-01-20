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
import com.plohoy.enterpriseservice.util.idHelper;
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
    @Autowired private idHelper idHelper;
    private String externalRandomid;

    private String infoTypeName;
    private String testidFromSql;
    private int testResponseFromSqlLength;

    public GetInfoControllerTest(
            String infoTypeName,
            String testidFromSql,
            int testResponseFromSqlLength
    ) {
        this.infoTypeName = infoTypeName;
        this.testidFromSql = testidFromSql;
        this.testResponseFromSqlLength = testResponseFromSqlLength;
    }

    @Parameterized.Parameters(name = "{0} test")
    public static Collection<Object[]> data() {
        return Arrays.asList(TestCaseBuilder.getSqlTestCases());
    }

    @Before
    public void initid() {
        do {
            externalRandomid = idHelper.getRandomid();
        } while (externalRandomid == testidFromSql);
    }

    @Test
    @Sql(value = "/sql/create-info-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "/sql/drop-info-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void shouldGetInfoFromDB() throws Exception {
        MvcResult mvcResult = mvc.perform(
                get(String.format("/%s/%s", infoTypeName, testidFromSql)))
                .andDo(print())
                .andExpect(handler().methodName("getInfo"))
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
    public void failedByLargeid() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, idHelper.getLargeid())))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                idHelper.getidSizeErrorMessage(),
                                idHelper.getMinidSizeProperty(),
                                idHelper.getMaxidSizeProperty()))));
    }

    @Test
    public void failedBySmallid() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, idHelper.getSmallid())))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                idHelper.getidSizeErrorMessage(),
                                idHelper.getMinidSizeProperty(),
                                idHelper.getMaxidSizeProperty()))));
    }

    @Test
    public void failedByNormalInvalidid() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, idHelper.getSmallid() + "-")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(
                        Matchers.containsString(idHelper.getidFormatErrorMessage())));
    }

    @Test
    public void failedByLargeInvalidid() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, idHelper.getLargeid() + "-")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                idHelper.getidSizeErrorMessage(),
                                idHelper.getMinidSizeProperty(),
                                idHelper.getMaxidSizeProperty()))))
                .andExpect(content().string(
                        Matchers.containsString(idHelper.getidFormatErrorMessage())));
    }

    @Test
    public void failedByNormalSpaceid() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, idHelper.getSmallid() + " ")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(
                        Matchers.containsString(idHelper.getidFormatErrorMessage())));
    }

    @Test
    public void failedByLargeSpaceid() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, idHelper.getLargeid() + " ")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                idHelper.getidSizeErrorMessage(),
                                idHelper.getMinidSizeProperty(),
                                idHelper.getMaxidSizeProperty()))))
                .andExpect(content().string(
                        Matchers.containsString(idHelper.getidFormatErrorMessage())));
    }

    @Test
    public void failedByNormalLetterid() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, idHelper.getSmallid() + "q")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(
                        Matchers.containsString(idHelper.getidFormatErrorMessage())));
    }

    @Test
    public void failedByLargeLetterid() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, idHelper.getLargeid() + "q")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                idHelper.getidSizeErrorMessage(),
                                idHelper.getMinidSizeProperty(),
                                idHelper.getMaxidSizeProperty()))))
                .andExpect(content().string(
                        Matchers.containsString(idHelper.getidFormatErrorMessage())));
    }

    @Test
    public void failedByBlankid() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, " ")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString(
                        String.format(
                                idHelper.getidSizeErrorMessage(),
                                idHelper.getMinidSizeProperty(),
                                idHelper.getMaxidSizeProperty()))))
                .andExpect(content().string(
                        Matchers.containsString(idHelper.getidFormatErrorMessage())))
                .andExpect(content().string(
                        Matchers.containsString(idHelper.getidBlankErrorMessage())));
    }

    @Test
    public void failedByEmptyid() throws Exception {
        mvc.perform(
                get(String.format("/%s/%s", infoTypeName, "")))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.emptyString()));
    }

    @Test
    public void failedByExternalid() throws Exception {
        MvcResult mvcResult = mvc.perform(
                get(String.format("/%s/%s", infoTypeName, externalRandomid)))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        String errorMessage = mvcResult.getResponse().getErrorMessage();
        assertEquals(idHelper.getidNotFoundMessage(), errorMessage);
    }
}
