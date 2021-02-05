import * as React from "react";

import CarForm from './CarForm';

import { Create, useTranslate, SimpleForm } from 'react-admin';

import CarToolbar from './CarToolbar';

/**
 * Fromulaire de création de voiture
 * @param {*} props
 */import styles from '../../styles/forms.module.css';

const CreateCar = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm toolbar={<CarToolbar />}>
      <CarForm />
      </SimpleForm>
  </Create>
}

export default CreateCar;