import * as React from "react";
import {
  Create,
  SimpleForm,
  useTranslate
} from "react-admin";

import Name from '../form/name';
import styles from '../../styles/forms.module.css';

const CreateRegion = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>
          <section className={styles.form}>

      <Name />
            </section>

    </SimpleForm>
  </Create>
}

export default CreateRegion
