package utils;

public class FormatXml {

    public String formatXmlMethod(String xml) {
        try {
            xml = xml.replaceFirst("<\\?xml.*?\\?>", "").trim();

            StringBuilder formatted = new StringBuilder();
            int indent = 0;
            boolean inTag = false;

            for (int i = 0; i < xml.length(); i++) {
                char c = xml.charAt(i);

                if (c == '<') {
                    if (i + 1 < xml.length() && xml.charAt(i + 1) == '/') {
                        // Closing tag
                        indent--;
                        formatted.append("\n").append("  ".repeat(Math.max(0, indent)));
                    } else if (!inTag) {
                        // Opening tag
                        formatted.append("\n").append("  ".repeat(indent));
                    }
                    inTag = true;
                } else if (c == '>') {
                    inTag = false;
                    if (i > 0 && xml.charAt(i - 1) != '/') {
                        if (i + 1 < xml.length() && xml.charAt(i + 1) != '<') {
                        } else {
                            indent++;
                        }
                    }
                }

                formatted.append(c);
            }

            return formatted.toString().trim();
        } catch (Exception e) {
            return xml; // Return original if formatting fails
        }

    }

}
