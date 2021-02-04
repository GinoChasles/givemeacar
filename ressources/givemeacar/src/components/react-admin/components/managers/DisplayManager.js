import {
    Datagrid, Filter, List, SearchInput, TextField, ReferenceField, EmailField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayManager = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.manager')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('word.id')} source="id" />

            <TextField label={t('word.firstName')} source="firstName" />

            <TextField label={t('word.lastName')} source="lastName" />

            <EmailField label={t('word.mail')} source="mail" />

            <TextField label={t('word.phone')} source="phone" />

            <ReferenceField link='show' label={t('word.agency')} source="agency_id" reference="agencies">
                <TextField source="name" />
            </ReferenceField>
        </Datagrid>
    </List>
}
export default DisplayManager