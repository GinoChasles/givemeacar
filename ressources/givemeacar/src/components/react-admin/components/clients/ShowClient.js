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

    return <Show {...props} title={t('custom.description')}>
        <SimpleShowLayout>

            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.firstName')} source="firstName" />

            <TextField label={t('custom.lastName')} source="lastName" />

            <EmailField label={t('custom.mail')} source="mail" />

            <TextField label={t('custom.password')} source="password" />

            <TextField label={t('custom.phone')} source="phone" />

            <TextField label={t('custom.address')} source="address" />

            <ReferenceField link='show' label={t('custom.agency')} source="agency_id" reference="agencies">
                <TextField source="name" />
            </ReferenceField>
        </SimpleShowLayout>
    </Show>
}

export default ShowClient;
