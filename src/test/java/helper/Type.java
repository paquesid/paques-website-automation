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
<<<<<<< HEAD
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
=======
    }
>>>>>>> 52784e8397daeab6c516ce44189a635d07b43c73
}
