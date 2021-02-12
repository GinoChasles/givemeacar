import React from "react";
import redirect from '../../lib/redirectIfSession'

const ForgotPassword = () => {
    return <>
      { redirect(false, '/signin')}
      mot de passe oublié
    </>
  }

export default ForgotPassword;