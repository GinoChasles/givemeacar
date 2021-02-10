import * as React from "react";
import {
  Create,
  SimpleForm,
  useTranslate
} from "react-admin";

import FirstName from '../form/firstName';
import LastName from '../form/lastName';
import Mail from '../form/mail';
import Phone from '../form/phone';
import Password from '../form/password';

import City from '../form/city';
import Street from '../form/street';
import Suffix from '../form/suffix';
import StreetNumber from '../form/streetNumber';
import Agency from '../form/agency';

import styles from '../../styles/forms.module.css';

const CreateClient = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>
      <section className={styles.form}>

      <FirstName />
      
      <LastName />
      
      <Mail />

      <Phone />
      
      <Password />
      
      <StreetNumber />
      
      <Suffix />
      
      <Street />
      
      <City />

      <Agency />
      </section>

    </SimpleForm>
  </Create>
}
export default CreateClient