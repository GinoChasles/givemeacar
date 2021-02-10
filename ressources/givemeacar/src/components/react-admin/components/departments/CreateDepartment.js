import * as React from "react";
import {
  Create,
  SimpleForm,
  useTranslate
} from "react-admin";


import Name from '../form/name';
import Code from '../form/code';
import Region from '../form/region';
import styles from '../../styles/forms.module.css';

const CreateDepartment = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>
      <section className={styles.form}>

      <Region />

      <Code />

      <Name />
      </section>

    </SimpleForm>
  </Create>
}

export default CreateDepartment
