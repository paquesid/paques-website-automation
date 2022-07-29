package helper;

public enum Environment {
    
    PDS {
        @Override
        public String toString(){
            return "PDS";
        }
    },

    PCC {
        @Override
        public String toString(){
            return "PCC";
        }
    },

    PAMEDI {
        @Override
        public String toString(){
            return "PAMEDI";
        }
    }
}
