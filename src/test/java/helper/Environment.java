package helper;

public enum Environment {
    
    DEV {
        @Override
        public String toString(){
            return "dev";
        }
    },

    STAGING {
        @Override
        public String toString(){
            return "staging";
        }
    },

    PRODUCTION {
        @Override
        public String toString(){
            return "production";
        }
    }
}
