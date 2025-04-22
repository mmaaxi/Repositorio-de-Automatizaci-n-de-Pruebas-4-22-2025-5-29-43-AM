Feature: Validate addition of the 'Folio de Pago' column in the Excel report

  Scenario: Generate report and verify 'Folio de Pago' column
    Given the user has generated the report and opened the Excel file
    Then the Excel sheet should display the column 'Folio de Pago' next to 'Folio Pre solicitud' without any data initially