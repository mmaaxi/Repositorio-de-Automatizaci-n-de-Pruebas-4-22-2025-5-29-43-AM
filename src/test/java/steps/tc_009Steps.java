package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.tc_009Page;

public class tc_009Steps {
    tc_009Page page = new tc_009Page();

    @Given("the user has generated the report and opened the Excel file")
    public void the_user_has_generated_the_report_and_opened_the_excel_file() {
        page.openExcelFile();
    }

    @Then("the Excel sheet should display the column 'Folio de Pago' next to 'Folio Pre solicitud' without any data initially")
    public void the_excel_sheet_should_display_the_column_folio_de_pago_next_to_folio_pre_solicitud_without_any_data_initially() {
        Assert.assertTrue("The 'Folio de Pago' column is not correctly placed or not empty initially", page.isFolioDePagoColumnCorrect());
    }
}