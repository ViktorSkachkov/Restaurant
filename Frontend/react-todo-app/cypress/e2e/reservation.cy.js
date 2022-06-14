describe('The Home Page', () => {
  it('sets auth cookie when logging in via form submission', function () {
    cy.visit('http://localhost:3000')
    const username = "dragonslayer";
    const pwd = "mahata";
    cy.visit('http://localhost:3000/login')
    cy.get('input[name=username]').type(username)

    // {enter} causes the form to submit
    cy.get('input[name=password]').type(`${pwd}{enter}`)

    // we should be redirected to /login
    cy.url().should('include', 'http://localhost:3000/')

    cy.get('.testEmployeeReservation')
        .click()
    const numberOfPeople = 4;
    const startTime = '2022-07-15T18:30';
    const finishTime = '2022-07-15T20:30';
    const preferences = 'None';
    cy.get('input[name=numberOfPeople]').type(`${numberOfPeople}`);
    cy.get('input[name=startTime]').type(startTime)
    cy.get('input[name=finishTime]').type(finishTime)
    cy.get('select[name=preferences]').type(`${preferences}{enter}`)

    cy.url().should('include', 'http://localhost:3000/successfullyAddedReservation')

    cy.get('.normalButton')
        .click()

    cy.get('.testEmployeeLogOut')
        .click()

    cy.get('.normalButton')
        .eq(0)
        .click()
    cy.get('.testNullLogIn')
        .click()
    //logging as employee

    const username2 = "asoiaf";
    const pwd2 = "eagleSigil";
    //cy.visit('http://localhost:3000/login')
    cy.get('input[name=username]').type(username2)

    // {enter} causes the form to submit
    cy.get('input[name=password]').type(`${pwd2}{enter}`)

    // we should be redirected to /login
    cy.url().should('include', 'http://localhost:3000/')

    cy.get('.testWorkerReservations')
        .click()

    cy.get('.reservationItemButton')
        .eq(4)
        .click()

    cy.get('.assignButton')
        .eq(0)
        .click()

    cy.get('.normalButton')
        .click()

    cy.get('.back')
        .click()

    /*cy.get('.reservationItemButton')
        .eq(7)
        .click()

    cy.url().should('include', 'http://localhost:3000/successfullyDeletedReservation')

    cy.get('.normalButton')
        .click()*/
  })
})