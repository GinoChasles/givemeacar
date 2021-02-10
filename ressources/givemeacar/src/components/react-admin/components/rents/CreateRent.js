import * as React from "react";
import {
  DateTimeInput,
  Create,
  SimpleForm,
  required,
  useTranslate
} from "react-admin";

import Client from '../form/client';
import Car from '../form/car';
import styles from '../../styles/forms.module.css';

const CreateRent = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>
      <section className={styles.form}>

      <DateTimeInput label={t('word.rentStart')} source="start" validate={[
        required()
      ]} />

      <DateTimeInput label={t('word.rentEnd')} source="end" validate={[
        required()
      ]} />

      <Car />

      <Client />
      </section>

    </SimpleForm>
  </Create>
}
export default CreateRent