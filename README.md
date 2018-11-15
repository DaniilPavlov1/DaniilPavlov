# DaniilPavlov
HW 3 Mobile TA

*1. Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?

    Now there is only one driver object for every test suite.
    We have access to one common driver instance from all tests.

*2. Suggest improvements for .properties reading. What are the purposes?

    1. Use BufferedInputStream for fast access to data).
    2. Use "try-with-resources", it prevents us from mistake such as forget close InputStream;

*3. Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test

    1. Added check for screen title.
    2. Added checks for field’s titles.
    3. Added checks for fields.
    4. Added check for virtual keyboard.
    5. Added checks for spinners.
    6. Added check for "Save" button.

*4. Optional: Add keyboard presence check in “native” test.

    To check keyboard is displayed I used the method hideKeyboard() which throw exception
    if it tries hide keyboard but keyboard isn't presented.

*5. Which checks would you place in the “web” test?

    1. Check response code of the target page.
    2. Check header logo is displayed.
    3. Check page title have proper text.
    4. Check that header is presented.
    5. Check header content: logo, intro text, link (visible and have proper texts).
    6. Check that there are three sections with visible titles, texts and links with proper texts.
    7. Check that search panel and footer is displayed.


