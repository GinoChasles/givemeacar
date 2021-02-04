import {
    Datagrid,
    List,
    ReferenceField,
    TextField,
    Filter,
    SearchInput,
    useTranslate
} from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <SearchInput source="zipcode" />
    </Filter>
);
const DisplayCity = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('custom.cities')} filters={<PostFilter />}>

        <Datagrid rowClick="edit">
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.name')} source="name" />

            <TextField label={t('custom.zipcode')} source="zipcode" />

            <ReferenceField link="show" label={t('custom.department')} source="department_id" reference="departments">
                <TextField source="name" />
            </ReferenceField>
            <ReferenceField link="show" label={t('custom.region')} source="regionId" reference="regions">
                <TextField source="name" />
            </ReferenceField>

        </Datagrid>
    </List>
}

export default DisplayCity