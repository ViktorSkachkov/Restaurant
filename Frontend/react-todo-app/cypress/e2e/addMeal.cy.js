describe('The Home Page', () => {
  it('sets auth cookie when logging in via form submission', function () {
    cy.visit('http://localhost:3000')
    const username = "asoiaf";
    const pwd = "eagleSigil";
    cy.visit('http://localhost:3000/login')
    cy.get('input[name=username]').type(username)

    // {enter} causes the form to submit
    cy.get('input[name=password]').type(`${pwd}{enter}`)

    // we should be redirected to /login
    cy.url().should('include', 'http://localhost:3000/')

    cy.get('.testWorkerMeals')
        .click()

    cy.get('.normalButton')
        .eq(0)
        .click()

    cy.fixture('Caesar.jpg').then(fileContent => {
      cy.get('input[type="file"]').attachFile({
        fileContent: fileContent.toString(),
        fileName: 'Caesar.jpg',
        mimeType: 'image/jpg'
      });
    });

    const name = "Name"
    const description = "Description";
    const weight = 350;
const price = 7;
const category = "Pizza";
    cy.get('input[name="name"]').type(name)

    cy.get('input[name="description"]').type(description)

    cy.get('input[name="weight"]').type(`${weight}`)

    cy.get('input[name="price"]').type(`${price}`)

    //cy.get('input[name="username"]').type(username)

    cy.get('select[name="category"]').type(`${category}{enter}`)

    cy.get('.normalButton')
        .click()

    cy.get('.viewMenusButton')
        .eq(12)
        .click()

    const name2 = "Name2"
    const description2 = "Description2";
    const weight2 = 400;
    const price2 = 9;
    const category2 = "Pizza";
    cy.get('input[name="name"]').clear()

    cy.get('input[name="name"]').type(name2)

    cy.get('input[name="description"]').clear()

    cy.get('input[name="description"]').type(description2)

    cy.get('input[name="weight"]').clear()

    cy.get('input[name="weight"]').type(`${weight2}`)

    cy.get('input[name="price"]').clear()

    cy.get('input[name="price"]').type(`${price2}`)

    //cy.get('input[name="username"]').type(username)

    cy.get('select[name="category"]').type(`${category2}{enter}`)

    cy.url().should('include', 'http://localhost:3000/successfullyUpdatedMeal/Name2')

    cy.get('.normalButton')
        .click()

    cy.get('.viewMenusButton')
        .eq(13)
        .click()

      cy.url().should('include', 'http://localhost:3000/successfullyDeletedMeal/Name2')

    cy.get('.normalButton')
        .click()

    cy.get('.testWorkerHome')
        .click()
    /*cy.fixture('Caesar.jpg').as('logo')
    cy.get('input[type=file]').then(function (input) {
      // convert the logo base64 string to a blob
      const blob = Cypress.Blob.base64StringToBlob(this.logo, 'image/jpg')
      input.fileupload('add', { files: blob })
    })*/








   /* const filepath = '/ricePudding.jpg'
    cy.get('input[type="file"]').attachFile(filepath)
    cy.get('#file-submit').click()
    cy.get('#uploaded-files').contains('ricePudding.jpg')
*/
    /*cy.get('#file-upload').selectFile('cypress/fixtures/images/evening.png')
    cy.get('#file-submit').click()
    cy.get('#uploaded-files').contains('evening.png')*/
  })
})