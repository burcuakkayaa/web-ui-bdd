package utils;

public enum MenuEnum {



        AboutUs("About us"), Partners("Partners"), Careers("Careers"),
        ContactUs("Contact us"), Glossary("Glossary"),Newsroom("Newsroom");


        private final String value;

        MenuEnum(String value) {
                this.value = value;
        }



        public String getValue() {
                return value;
        }

}
