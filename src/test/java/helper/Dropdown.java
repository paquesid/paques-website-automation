package helper;

public enum Dropdown {
    
    INDEX {
        @Override
        public String toString(){
            return "index";
        }
    },

    VALUE {
        @Override
        public String toString(){
            return "value";
        }
    },

    VISIBLETEXT {
        @Override
        public String toString(){
            return "text";
        }
    }
}
