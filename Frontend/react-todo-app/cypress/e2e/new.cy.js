describe('The Home Page', () => {
  it('sets auth cookie when logging in via form submission', function () {
    const username = "asoiaf";
    const pwd = "eagleSigil";
    cy.visit('http://localhost:3000/login')
    cy.get('input[name=username]').type(username)

    // {enter} causes the form to submit
    cy.get('input[name=password]').type(`${pwd}{enter}`)
  });
});