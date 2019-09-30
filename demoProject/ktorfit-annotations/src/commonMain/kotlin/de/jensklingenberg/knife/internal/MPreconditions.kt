package de.jensklingenberg.knife.internal

class MPreconditions{
   companion object{
       fun <T> checkNotNull(reference: T?, errorMessage: String?=""): T {
           if (reference == null) {
               throw NullPointerException(errorMessage)
           }
           return reference
       }
   }
}