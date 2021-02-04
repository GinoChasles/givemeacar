import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
} from "react-admin";


const ShowAdministrators = (props) => {

    const t = useTranslate();

    return <Show {...props}>
        <SimpleShowLayout>
            <TextField label={t('custom.firstName')} source="firstName" />
            <TextField label={t('custom.lastName')} source="lastName" />
            <TextField label={t('custom.mail')} source="mail" />
            <TextField label={t('custom.phone')} source="phone" />
        </SimpleShowLayout>
    </Show>
}

export default ShowAdministrators;
