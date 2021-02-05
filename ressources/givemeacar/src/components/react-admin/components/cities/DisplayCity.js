import {
    Datagrid,
    List,
    ReferenceField,
    TextField,
    Filter,
    SearchInput,
    useTranslate,
    EditButton,
    DeleteButton
} from "react-admin";
import * as React from "react";

const CityFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayCity = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.cities')} filters={<CityFilter />} exporter={false} perPage={25}>

        <Datagrid hasBulkActions rowClick="show">


            <TextField label={t('word.name')} source="name" />

            <TextField label={t('word.zipcode')} source="zipcode" />

            <ReferenceField link="show" label={t('word.department')} source="department_id" reference="departments">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('word.region')} source="regionId" reference="regions">
                <TextField source="name" />
            </ReferenceField>

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayCity