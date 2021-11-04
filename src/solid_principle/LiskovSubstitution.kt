package solid_principle

import java.util.*

class BeforeLiskovSubstitution() {
    abstract class Product {
        abstract fun getName(): String?
        abstract fun getExpiredDate(): Date?

        /**
         * Function to get all of information about product
         */
        fun getProductInfo() {
            // some magic code
        }
    }

    class Vegetable : Product() {

        override fun getName(): String {
            return "Broccoli"
        }

        override fun getExpiredDate(): Date {
            return Date()
        }
    }


    class Smartphone : Product() {

        override fun getName(): String {
            return "Samsung S10+ Limited Edition"
        }

        override fun getExpiredDate(): Date {
            return Date() // ???????
        }
    }
}

class LiskovSubstitution {
    abstract class Product {
        abstract fun getName(): String

        /**
         * Function to get all of information about product
         */
        fun getProductInfo() {
            // some magic code
        }
    }

    abstract class FoodProduct : Product() {
        abstract fun getExpiredDate(): Date
    }

    class Smartphone : Product() {

        override fun getName(): String {
            return "Samsung S10+ Limited Edition"
        }
    }

    class Vegetable : FoodProduct() {

        override fun getName(): String {
            return "Broccoli"
        }

        override fun getExpiredDate(): Date {
            return Date()
        }
    }
}