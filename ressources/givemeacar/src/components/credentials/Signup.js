import React from "react";
import redirect from '../../lib/redirectIfSession'

const Signup = () => {
  return <>
    { redirect(false, '/signin')}
    <div>s'inscrire</div>
    </>
  }

export default Signup;