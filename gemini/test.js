gemini.suite('gisauto.verstka', (suite) => {
    suite.setUrl('/')
        .setCaptureElements('body > div.apex_index > div.apex__logo.apex__logo_index > img')
        .capture('plain');
});