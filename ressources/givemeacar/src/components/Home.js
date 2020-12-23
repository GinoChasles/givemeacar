import React from 'react'

import LoginForm from '../components/forms/LoginForm'

import redirect from '../lib/redirectIfNoSession'

export default function Home() {
  return (
    <div>
      {redirect('/')}
      Home
           </div>
  )
}
