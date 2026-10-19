package com.magovoice.audion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magovoice.audion.model.FlowResponse;
import com.magovoice.audion.model.Output;
import com.magovoice.audion.model.Utterance;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DynamicOutputTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void preservesFlowSpecificOutputFields() throws Exception {
        String payload = "{"
                + "\"status\":\"success\","
                + "\"message\":\"Flow execution completed\","
                + "\"content\":{\"output\":{"
                + "\"biomarkerResultPath\":\"exp/biomarkers/result.json\","
                + "\"mllm\":{\"future_plan\":\"재방문\"},"
                + "\"utterances\":[{"
                + "\"text\":\"테스트\","
                + "\"vad_scores\":{\"valence\":0.7},"
                + "\"principal_biomarker_evaluations\":{"
                + "\"pitch:f0_mean\":{\"value\":120.5,\"unit\":\"Hz\",\"level\":\"typical\"}"
                + "}}]}}}";

        FlowResponse response = objectMapper.readValue(payload, FlowResponse.class);
        Output output = response.getContent().getOutput();
        assertEquals(
                "exp/biomarkers/result.json",
                output.getAdditionalProperties().get("biomarkerResultPath")
        );
        assertEquals("재방문", output.getMllm().getAdditionalProperties().get("future_plan"));

        Utterance utterance = output.getUtterances().get(0);
        assertEquals(0.7, utterance.getVadScores().get("valence"));
        assertEquals(
                "Hz",
                utterance.getPrincipalBiomarkerEvaluations().get("pitch:f0_mean").getUnit()
        );
        assertNotNull(utterance.getPrincipalBiomarkerEvaluations().get("pitch:f0_mean").getValue());

        String encoded = objectMapper.writeValueAsString(response);
        Map<?, ?> roundTrip = objectMapper.readValue(encoded, Map.class);
        Map<?, ?> content = (Map<?, ?>) roundTrip.get("content");
        Map<?, ?> encodedOutput = (Map<?, ?>) content.get("output");
        assertEquals("exp/biomarkers/result.json", encodedOutput.get("biomarkerResultPath"));
    }
}
