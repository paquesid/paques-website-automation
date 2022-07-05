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
    GROUPNAME {
        @Override
        public String toString(){
            return "";
        }
    }, 
    ROLENAME {
        @Override
        public String toString(){
            return "";
        }
    }, ROLEDESCRIPTION, SCOPE
}
