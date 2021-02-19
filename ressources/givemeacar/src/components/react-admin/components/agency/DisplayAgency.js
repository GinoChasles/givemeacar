import { Datagrid, Filter, List, ReferenceInput, SearchInput, TextField, useTranslate } from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="name" reference="agencies" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput source="city_id" reference="cities" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput source="street_id" reference="streets" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
    </Filter>
);

const DisplayAgency = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('custom.agencies')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">

            <TextField source="id" label={t("custom.id")} />

            <TextField source="name" label={t("custom.name")} />

            <TextField source="streetNumber" label={t("custom.number")} />
            <TextField source="streetSuffix.name" label={t("custom.suffix")} />
            <TextField source="street.name" label={t("custom.street")} />
            <TextField source="city.zipcode" label={t("custom.zipcode")} />
            <TextField source="city.name" label={t("custom.city")} />
        </Datagrid>
    </List>
}

export default DisplayAgency