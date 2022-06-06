package helper;

public enum Type {
    
    USERNAME {
        @Override
        public String toString(){
            return "username";
        }
    },

    EMAIL {
        @Override
        public String toString(){
            return "email";
        }
    },

    NOTMATCH {
        @Override
        public String toString(){
            return "passwordNotMatch";
        }
    },

    PASSWORD {
        @Override
        public String toString(){
            return "password";
        }
    },

    REPASSWORD {
        @Override
        public String toString(){
            return "rePassword";
        }
    },

    FIRSTNAME {
        @Override
        public String toString(){
            return "firstName";
        }
    },

    LASTNAME {
        @Override
        public String toString(){
            return "lastName";
        }
    },

    ROLENAME {
        @Override
        public String toString(){
            return "rolename";
        }
    },

    ROLEDESCRIPTION {
        @Override
        public String toString(){
            return "roledescription";
        }

    },

    SCOPE {
        @Override
        public String toString(){
            return "scope";
        }
    }
}
