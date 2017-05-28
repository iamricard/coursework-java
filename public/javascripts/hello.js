function boot() {
  const app = document.querySelector('#app')


  app.addEventListener('click', (evt) => {
    const current = document.querySelector('.show')
    const next = document.querySelector('.show + .question-container')

    if (evt.target.classList.contains('option')) {
      if (next) {
        current.classList.remove('show')
        next.classList.add('show')
      } else {
        setTimeout(() => {
          const answers =
            [...document.querySelectorAll('input[type="radio"]:checked')]
              .map(input => input.value)
              .join('')

          location.href = `/complete?answers=${answers}`
        }, 0)
      }
    }
  })
}

boot()