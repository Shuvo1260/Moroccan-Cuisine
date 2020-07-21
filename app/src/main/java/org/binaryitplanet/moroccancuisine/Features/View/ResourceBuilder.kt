package org.binaryitplanet.moroccancuisine.Features.View
//
//import org.apache.poi.ss.usermodel.FormulaEvaluator
//import org.apache.poi.ss.usermodel.Row
//import org.apache.poi.xssf.usermodel.XSSFWorkbook
//import java.io.File
//import java.io.FileInputStream
//
//private val RECIPE_FILE_NAME = "./app/src/main/res/values/recipes.xml"
//private val TITLE_FILE_NAME = "./app/src/main/res/values/food_names.xml"
//private val EXCEL_FILE_NAME = "./food_details.xlsx"
//
//fun main(args: Array<String>) {
//    readFoodDetails()
//}
//
//
//// Reading from excel file
//private fun readFoodDetails() {
//
//    try {
//        val inputStream = FileInputStream(EXCEL_FILE_NAME)
//
//        val workBook = XSSFWorkbook(inputStream)
//
//        val sheet = workBook.getSheetAt(0)
//
//        val rowCount = sheet.physicalNumberOfRows
//
//        val formulaEvaluator = workBook.creationHelper.createFormulaEvaluator()
//
//        var recipes = arrayListOf<String>()
//        var titles = arrayListOf<String>()
//
//        for (rowIndex in 0 until rowCount) {
//            val row = sheet.getRow(rowIndex)
//
//            val cellsCount = row.physicalNumberOfCells
//
//            var cellValues = arrayListOf<String>()
//
//            for (cellIndex in 0 until cellsCount) {
//                val value = getCellAsString(row, cellIndex, formulaEvaluator)
//
//                cellValues.add(value)
//
//            }
//
//            if (cellValues[0].trim() == ""
//                || cellValues[0].trim() == null
//                || cellValues[0].trim() == "Finished")
//                break
//
//            titles.add(cellValues[0].trim())
//            recipes.add(
//                cellValues[1].trim()
//                    .replace("\n", "\\n")
//                    .replace("’", "\\’")
//            )
//
//
//
//
//        }
//
//        println("Titles: $titles")
//        println("Recipes: $recipes")
//
//        saveFoodDetails(titles, recipes)
//
//    } catch (e: Exception) {
////        Log.d(TAG, "error: ${e.message}")
//        println("Error: ${e.message}")
//    }
//}
//
//private fun getCellAsString(row: Row, cellIndex: Int, formulaEvaluator: FormulaEvaluator): String {
//    var value = ""
//    try {
//        val cell = row.getCell(cellIndex)
//        val cellValue = formulaEvaluator.evaluate(cell)
//
//        if (cellValue.stringValue == "\n")
//            println("NewLine")
//
//        value += " " + cellValue.stringValue
//            .replace("\'", "\\\'")
//    }catch (e: Exception) {
//        println("FormatingError: ${e.message}")
//    }
//
//    return value
//}
//
//// Writing into text file
//private fun saveFoodDetails(
//    titles: ArrayList<String>,
//    recipes: ArrayList<String>
//) {
//    try {
//
//        var titleHead = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "<resources>\n" +
//                "\n" +
//                "\t\n" + "<string-array name=\"foodNames\">\n"
//
//        var recipeHead = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "<resources>\n" +
//                "\n" +
//                "\t\n" + "<string-array name=\"recipes\">\n"
//
//        var tail = "\t</string-array>\n" +
//                "\n" +
//                "</resources>"
//
//        var titleFileOutputStream = File(TITLE_FILE_NAME)
//        var recipeFileOutputStream = File(RECIPE_FILE_NAME)
//
//
//        titleFileOutputStream.writeBytes(titleHead.toByteArray())
//
//        titles.forEach {
//            titleFileOutputStream.appendBytes("<item>".toByteArray())
//            titleFileOutputStream.appendBytes(
//                it.toByteArray()
//            )
//            titleFileOutputStream.appendBytes("</item>".toByteArray())
//            titleFileOutputStream.appendBytes("\n".toByteArray())
//        }
//
//        titleFileOutputStream.appendBytes(tail.toByteArray())
//
//        recipeFileOutputStream.writeBytes(recipeHead.toByteArray())
//
//        recipes.forEach {
//            recipeFileOutputStream.appendBytes("<item>".toByteArray())
//            recipeFileOutputStream.appendBytes(
//                it.toByteArray()
//            )
//
//            recipeFileOutputStream.appendBytes("</item>".toByteArray())
//            recipeFileOutputStream.appendBytes("\n".toByteArray())
//        }
//
//        recipeFileOutputStream.appendBytes(tail.toByteArray())
//
//    } catch (e: Exception) {
//        println("FileWriteError: ${e.message}")
//    }
//}