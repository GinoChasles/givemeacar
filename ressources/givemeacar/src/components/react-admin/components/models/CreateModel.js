import * as React from "react";
import {
  Create,
  SimpleForm,
  useTranslate
} from "react-admin";

import Name from '../form/name';
import Brand from '../form/brand';
import styles from '../../styles/forms.module.css';

const CreateModel = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>
      <section className={styles.form}>

      <Brand />

      <Name />
      </section>

    </SimpleForm>
  </Create>
}
export default CreateModel