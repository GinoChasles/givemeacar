import * as React from "react";

import { useTranslate } from "react-admin";

import {
    Show,
    SimpleShowLayout,
    TextField,
    EmailField,
    ReferenceField

} from "react-admin";


const ShowClient = (props) => {

    const t = useTranslate();

    return <Show {...props} title={t('word.description')}>
        <SimpleShowLayout>

            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.firstName')} source="firstName" />

            <TextField label={t('word.lastName')} source="lastName" />

            <EmailField label={t('word.mail')} source="mail" />

            <TextField label={t('word.password')} source="password" />

            <TextField label={t('word.phone')} source="phone" />

            <TextField label={t('word.address')} source="address" />

            <ReferenceField link='show' label={t('word.agency')} source="agency_id" reference="agencies">
                <TextField source="name" />
            </ReferenceField>
        </SimpleShowLayout>
    </Show>
}

export default ShowClient;
