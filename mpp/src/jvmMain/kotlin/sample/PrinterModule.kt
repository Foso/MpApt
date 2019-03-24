package sample

import annotation.Module


@Module
open class PrinterModule {


    fun providePrinter() = Printer()
}