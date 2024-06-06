import java.lang.Math;
    
    /**
     * The abstract Chef class represents a chef who can cook a specific type of dish.
     * It provides methods for cooking orders and managing the chain of responsibility.
     */
    public abstract class Chef {
        protected Chef nextChef = null;
        private String Especialidade = "";

        /**
         * Cooks the given order if the chef specializes in that type of dish.
         * If not, passes the order to the next chef in the chain.
         * 
         * @param Order the order to be cooked
         */
        public void cook(String Order) {
            if (Order.contains(getEspecialidade())) {
                int random = (int)(Math.random() * 18 + 9);
                System.out.println(this.toString() + ": Starting to cook " + Order + "." + " Out in " + random + " minutes!");
            } else {
                System.out.println(this.toString() + ": I can't cook that.");
                if (nextChef != null) {
                    nextChef.cook(Order);
                } else {
                    System.out.println("We're sorry but that request can't be satisfied by our service!");
                }
            }
        }

        /**
         * Returns the next chef in the chain.
         * 
         * @return the next chef
         */
        public Chef getNextChef() {
            return nextChef;
        }

        /**
         * Prints the information about the next chef in the chain.
         */
        public void printNextChef() {
            System.out.println("I am " + this.toString() + " next chef is: " + this.getNextChef().toString());
        }

        /**
         * Sets the next chef in the chain.
         * 
         * @param nextChef the next chef to be set
         */
        public void setNextChef(Chef nextChef) {
            this.nextChef = nextChef;
        }

        /**
         * Returns the specialty of the chef.
         * 
         * @return the specialty of the chef
         */
        public String getEspecialidade() {
            return Especialidade;
        }

        /**
         * Sets the specialty of the chef.
         * 
         * @param Especialidade the specialty to be set
         */
        public void setEspecialidade(String Especialidade) {
            this.Especialidade = Especialidade;
        }

        /**
         * Returns a string representation of the chef.
         * 
         * @return a string representation of the chef
         */
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }
