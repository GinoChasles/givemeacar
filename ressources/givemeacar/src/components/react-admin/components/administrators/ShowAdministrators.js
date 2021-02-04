import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
} from "react-admin";


const ShowAdministrators = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout>
            <TextField label={t('word.firstName')} source="firstName" />
            <TextField label={t('word.lastName')} source="lastName" />
            <TextField label={t('word.mail')} source="mail" />
            <TextField label={t('word.phone')} source="phone" />
        </SimpleShowLayout>
    </Show>
}

export default ShowAdministrators;
