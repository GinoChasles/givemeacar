import * as React from "react";
import {
  Create,
  SimpleForm,
  ReferenceInput,
  AutocompleteInput,
  TextInput,
  useTranslate
} from "react-admin";

import Name from '../form/name'
import Latitude from '../form/latitude'
import Longitude from '../form/longitude'
import Department from '../form/department'
import Zipcode from '../form/zipcode'
import styles from '../../styles/forms.module.css';

const CreateCity = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>
      <section className={styles.form}>

      <Zipcode />

      <Name />

      <Latitude />

      <Longitude />

      <Department />
      </section>

    </SimpleForm>
  </Create>
}
export default CreateCity
