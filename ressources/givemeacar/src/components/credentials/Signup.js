import React from "react";
import redirect from '../../lib/redirectIfNoSession'

const Signup = () => {
  return <>
      { redirect('/') }
    <div>s'inscrire</div>
    </>
  }

export default Signup;