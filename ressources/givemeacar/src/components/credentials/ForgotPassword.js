import React from "react";
import RedirectIfNoSession from '../RedirectIfSession'

const ForgotPassword = () => {
  return <>
    <RedirectIfNoSession session={false} route='/' />
      mot de passe oublié
    </>
  }

export default ForgotPassword;