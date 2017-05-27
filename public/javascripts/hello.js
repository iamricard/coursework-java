function boot() {
  const app = document.querySelector('#app')

  app.addEventListener('click', (evt) => {
    const current = document.querySelector('.show')
    const next = document.querySelector('.show + .question-container')

    if (evt.target.classList.contains('option')) {
      current.classList.remove('show')
      next.classList.add('show')
    }
  })
}

boot()