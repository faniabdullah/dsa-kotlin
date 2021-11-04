package solid_principle

class BeforeSRP() {
    class Order {
        fun calculateTotalSum() {/*...*/
        }

        fun getItems() {/*...*/
        }

        fun getItemCount() {/*...*/
        }

        fun addItem(item: Item) {/*...*/
        }

        fun deleteItem(item: Item) {/*...*/
        }

        fun printOrder() {/*...*/
        }

        fun showOrder() {/*...*/
        }

        fun getDailyHistory() {/*...*/
        }

        fun getMonthlyHistory() {/*...*/
        }

    }

    class Item
}

class SingleResponsibility {
    class Order {
        fun calculateTotalSum() {}
        fun getItems() {}
        fun getItemCount() {}
        fun addItem(item: Item) {}
        fun deleteItem(item: Item) {}
    }

    class Item
    class OrderHistory {
        fun getDailyHistory() {}
        fun getMonthlyHistory() {}
    }

    class OrderViewer {
        fun printOrder(order: Order) {}
        fun showOrder(order: Order) {}
    }
}