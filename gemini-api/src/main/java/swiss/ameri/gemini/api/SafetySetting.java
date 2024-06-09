package swiss.ameri.gemini.api;

/**
 * Safety settings according to <a href="https://ai.google.dev/api/rest/v1beta/SafetySetting#harmblockthreshold">SafetySetting</a>.
 */
public record SafetySetting(
        String category,
        String threshold
) {

    /**
     * Create a SafetySetting by using the provided enums. Use the constructor for custom string values that might
     * be missing in the enums.
     */
    public static SafetySetting of(
            HarmCategory category,
            HarmBlockThreshold threshold
    ) {
        return new SafetySetting(
                category == null ? null : category.name(),
                threshold == null ? null : threshold.name()
        );
    }

    /**
     * According to <a href="https://ai.google.dev/api/rest/v1beta/HarmCategory">HarmCategory</a>.
     * Currently, only the first 4 seem to be recognized as input.
     */
    public enum HarmCategory {
        /**
         * Harasment content.
         */
        HARM_CATEGORY_HARASSMENT,
        /**
         * Hate speech and content.
         */
        HARM_CATEGORY_HATE_SPEECH,
        /**
         * Sexually explicit content.
         */
        HARM_CATEGORY_SEXUALLY_EXPLICIT,
        /**
         * Dangerous content.
         */
        HARM_CATEGORY_DANGEROUS_CONTENT,
        /**
         * Category is unspecified.
         */
        HARM_CATEGORY_UNSPECIFIED,
        /**
         * Negative or harmful comments targeting identity and/or protected attribute.
         */
        HARM_CATEGORY_DEROGATORY,
        /**
         * Content that is rude, disrespectful, or profane.
         */
        HARM_CATEGORY_TOXICITY,
        /**
         * Describes scenarios depicting violence against an individual or group, or general descriptions of gore.
         */
        HARM_CATEGORY_VIOLENCE,
        /**
         * Contains references to sexual acts or other lewd content.
         */
        HARM_CATEGORY_SEXUAL,
        /**
         * Promotes unchecked medical advice.
         */
        HARM_CATEGORY_MEDICAL,
        /**
         * Dangerous content that promotes, facilitates, or encourages harmful acts.
         */
        HARM_CATEGORY_DANGEROUS,
    }

    /**
     * According to <a href="https://ai.google.dev/api/rest/v1beta/SafetySetting#harmblockthreshold">SafetySetting</a>
     */
    public enum HarmBlockThreshold {
        /**
         * Threshold is unspecified.
         */
        HARM_BLOCK_THRESHOLD_UNSPECIFIED,
        /**
         * Content with NEGLIGIBLE will be allowed.
         */
        BLOCK_LOW_AND_ABOVE,
        /**
         * Content with NEGLIGIBLE and LOW will be allowed.
         */
        BLOCK_MEDIUM_AND_ABOVE,
        /**
         * Content with NEGLIGIBLE, LOW, and MEDIUM will be allowed.
         */
        BLOCK_ONLY_HIGH,
        /**
         * All content will be allowed.
         */
        BLOCK_NONE
    }

}
