package helper;

public enum QueryCommands {
    
    DATATABULAR {
        @Override
        public String toString(){
            return "Data Tabular";
        }
    },

    SEARCHFILE {
        @Override
        public String toString(){
            return "Search File";
        }
    }
}
