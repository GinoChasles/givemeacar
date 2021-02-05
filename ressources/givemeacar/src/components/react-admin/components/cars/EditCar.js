import * as React from "react";
import CarForm from './CarForm';

import { Edit, useTranslate, SimpleForm } from 'react-admin';


import CarToolbar from './CarToolbar';

const EditCar = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')} >
        <SimpleForm toolbar={<CarToolbar />}>
            <CarForm />
        </SimpleForm>
    </Edit>
}

export default EditCar;