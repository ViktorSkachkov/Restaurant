describe('The Home Page', () => {
  it('sets auth cookie when logging in via form submission', function () {
    const username = "dragonslayer";
    const pwd = "mahata";
    cy.visit('http://localhost:3000/login')
    cy.get('input[name=username]').type(username)

    // {enter} causes the form to submit
    cy.get('input[name=password]').type(`${pwd}{enter}`)

    // we should be redirected to /login
    cy.url().should('include', 'http://localhost:3000/')

    // our auth cookie should be present
    cy.getCookie('your-session-cookie').should('exist')
  })
})