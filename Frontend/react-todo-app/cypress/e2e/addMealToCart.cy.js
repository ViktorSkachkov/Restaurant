http://localhost:3000/details8

    describe('The Home Page', () => {
      it('sets auth cookie when logging in via form submission', function () {
          //cy.visit('http://localhost:3000/login')
          cy.visit('http://localhost:3000')
          cy.get('.testNullLogIn')
              .click()

        const username = "dragonslayer";
        const pwd = "mahata";

          cy.get('input[name="username"]').type(username)

          // {enter} causes the form to submit
          cy.get('input[name=password]').type(`${pwd}{enter}`)

        // we should be redirected to /login
        cy.url().should('include', 'http://localhost:3000/')

cy.get('.testEmployeeMenus')
    .click()

          cy.get('.categoryItemButton')
              .eq(0)
              .click()

          cy.get('.detailsButton')
              .eq(0)
              .click()

          cy.get('.arrowButton')
              .eq(1)
              .click()

          cy.get('.normalButton')
              .click()

          cy.url().should('include', 'http://localhost:3000/successfullyAddedCartItem/Margherita/2/8')

          cy.get('.normalButton')
              .click()

          //ordering Pasta
          cy.get('.testEmployeeMenus')
              .click()

          cy.get('.categoryItemButton')
              .eq(1)
              .click()

          cy.get('.detailsButton')
              .eq(1)
              .click()

          cy.get('.arrowButton')
              .eq(1)
              .click()

          cy.get('.normalButton')
              .click()

          cy.url().should('include', 'http://localhost:3000/successfullyAddedCartItem/Lasagna/2/2')

          cy.get('.normalButton')
              .click()

          cy.get('.cartButton')
              .click()

          cy.get('.rightArrowCartButton')
              .eq(0)
              .click()

          cy.get('.cartButton')
              .eq(2)
              .click()

          cy.get('.normalButton')
              .click()

          cy.get('.normalButton')
              .click()
//log out

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

          cy.get('.testWorkerOrders')
              .click()


          cy.get('.normalButton')
              .eq(1)
              .click()
      })
    })