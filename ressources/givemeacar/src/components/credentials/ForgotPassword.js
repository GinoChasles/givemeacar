import React from "react";
import redirect from '../../lib/redirectIfNoSession'

const ForgotPassword = () => {
    return <>
      { redirect('/') }
      mot de passe oublié
    </>
  }

export default ForgotPassword;