import * as React from "react";

import {
  Create,
  SimpleForm,
  useTranslate
} from "react-admin";

import City from '../form/city';
import Street from '../form/street';
import Suffix from '../form/suffix';
import Name from '../form/name';
import StreetNumber from '../form/streetNumber';
import styles from '../../styles/forms.module.css';

const CreateAgency = (props) => {

  const t = useTranslate();

  return <>
    <Create {...props} title={t('word.creation')} >

      <SimpleForm on>
        <section className={styles.form}>

      <Name />
      <StreetNumber />
      <Suffix />
      <Street />
      <City />
        </section>

    </SimpleForm>
    </Create>
  </>
}

export default CreateAgency
