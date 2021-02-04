import { Edit, SimpleForm, useTranslate } from "react-admin";
import * as React from "react";

import FirstName from '../form/firstName';
import LastName from '../form/lastName';
import Mail from '../form/mail';
import Phone from '../form/phone';
import Password from '../form/password';

const EditAdministrators = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')}>
        <SimpleForm optionvalue={"id"}>

            <FirstName />
            <LastName />
            <Mail />
            <Phone />
            <Password />

        </SimpleForm>
    </Edit>
}

export default EditAdministrators